/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var pid;
function updateLike(postId){
    pid=postId;
    var url="LikeServlet";
    var param={postId:postId};
    jQuery.post(url,param,callbackResult);
}

function callbackResult(data){
    $("#badge_"+pid).html(data);
}