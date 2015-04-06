/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var browserType;
var jobj;

function createXHR() {
    
    // This function creates the correct form of the XMLHttpRequestObject based on the browser
    if (window.XMLHttpRequest) { // Mozilla, Safari,...
        XHR = new XMLHttpRequest();
        if (XHR.overrideMimeType) {
            XHR.overrideMimeType('text/html');
            }
        browserType="Mozilla"
        return XHR;
    } //end mozilla attempt
    if (window.ActiveXObject) { // IE
	try {
            XHR = new ActiveXObject("Msxml2.XMLHTTP");
            browserType="IE";
            return XHR;
	} 
        catch (e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                browserType="IE";
            }
            catch (e) {
                alert("Your browser does not support AJAX!");
                browserType="Unknown"
                return null;
                }
            }
    }//end IE attempt 
return null;
}





function reply(postid){
   
    var date = new Date().toISOString().slice(0, 19).replace('T', ' ');
    var input1 = document.getElementById("1_"+postid + "").value;
    var input2 = document.getElementById("2_"+postid + "").value;
    var input3 = document.getElementById("3_"+postid + "").value;
//    var input4 = document.getElementById("4_"+postid + "").value;
    var input5 = document.getElementById("5_"+postid + "").value;
    
//    alert(input5);
    var path = "CommentServlet?commentArea=" + input1 + "&postId="+ input2 +"&userId=" + input3;
    
    var xhr = createXHR();
    xhr.onreadystatechange = processResponse;
    xhr.open("POST", path, true);
    xhr.send(); 
    
    function processResponse() {  
      // readyState of 4 signifies request is complete

      
      if (xhr.readyState == 4) {
        
        // status of 200 signifies sucessful HTTP call
        alert(xhr.status);
        if (xhr.status == 200) {
        createNewComment(postid, input1, input5, date);
        
        
       
        
        }else{alert("Error during AJAX call. Please try again");}
      }
    }
     
    
}


function createNewComment(postid,input1, input5, date){
    var element = document.getElementById("bigComment_"+postid);
    
    
    var newCommentDiv = document.getElementById("newCommentDiv_" +postid);
    
    newCommentDiv.style.marginBottom = "4%";
    var addElement = newCommentDiv.cloneNode(true);
    
    element.insertBefore(addElement, element.firstChild);
    element.getElementsByTagName("p")[0].innerHTML = date;
    element.getElementsByTagName("p")[1].innerHTML = input5 +":";
    element.getElementsByTagName("p")[2].innerHTML = input1;
    newCommentDiv.removeAttribute('id');
}

function showModal(postid){
            
           $('#myModal_'+ postid).modal('show');
        }


