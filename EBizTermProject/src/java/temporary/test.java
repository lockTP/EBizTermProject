
package temporary;

/**
 *
 * @author duke
 */
public class test {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        
        SpiderMain spiderMain;    
        
        String actionStartSpider = request.getParameter("startSpider");   
        String actionLogOut = request.getParameter("logOut");
        
        if(actionStartSpider != null && actionStartSpider.equals("Start Spider")) {
            if(cveBeginID != null && cveEndID != null &&
               vulItemValidator.validateCveID(cveBeginID) && vulItemValidator.validateCveID(cveEndID) &&
               cveBeginID.compareToIgnoreCase(cveEndID) <= 0) {
                //get the root path of the project, where all those files are
                ServletContext context=this.getServletContext();
                String projectRootPath=context.getRealPath("/"); 
                projectRootPath = projectRootPath.replaceAll("(.+Assignment7_hab81).+", "$1");
                //projectRootPath = projectRootPath.replaceAll("\\\\", "/");
                projectRootPath += "/";
                
                spiderMain = new SpiderMain();
                spiderMain.setErrorFilePath(projectRootPath);
                spiderMain.setTempFilePath(projectRootPath);
                spiderMain.setSourceCveFilePath(projectRootPath);
                spiderMain.setJobsFilePath(projectRootPath);
                JobItemFlag.setRefSourceFilePath(projectRootPath);
                FilesUtility.setErrorFilePath(projectRootPath);
                FilesUtility.setTempFilePath(projectRootPath);
                spiderMain.startSpider();
                successMessage = "The spider has finished crawling information successfully.";
            }
            else {
                errorMessage = "The spider failed to crawl the information!";  
            }
            request.setAttribute("successMessage", successMessage);
            request.setAttribute("errorMessage", errorMessage);
            requestDispatcher = request.getRequestDispatcher("/vul/searchMain.jsp");
            requestDispatcher.forward(request, response);
        }
        else if(actionLogOut != null && actionLogOut.equals("Log Out")) {
            HttpSession session=request.getSession(false);  
            session.invalidate();
            requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            requestDispatcher = request.getRequestDispatcher("/error404.jsp");
            requestDispatcher.forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        VulItemManager vulItemManager = new VulItemManager();
        VulItemValidator vulItemValidator = new VulItemValidator();
        String errorMessage = null;
        String successMessage = null;
        VulItem vulItem;
        
        String actionUploadFile = request.getParameter("uploadFile");   
        
        String uploadFileName = request.getParameter("uploadFileName");
        
        if(actionUploadFile != null && actionUploadFile.equals("Upload") && uploadFileName != null) {
            //get the root path of the project, where all those files are
            ServletContext context=this.getServletContext();
            String projectRootPath=context.getRealPath("/"); 
            projectRootPath = projectRootPath.replaceAll("(.+Assignment7_hab81).+", "$1");
            //projectRootPath = projectRootPath.replaceAll("\\\\", "/");
            projectRootPath += "/";
            try {
                SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
                SAXParser saxParser = saxParserFactory.newSAXParser();
                DBFileHandler handler = new DBFileHandler();
                saxParser.parse(new File(projectRootPath + uploadFileName), handler);
                successMessage = "The content in vulitems.xml has been uploaded into the database successfully.";
            }
            catch(ParserConfigurationException | SAXException | IOException ex) {
                errorMessage = ex.toString() + "\r\n" + "Sorry, but all files should be put in the root paht of the project in advance!";
            }
            
            request.setAttribute("successMessage", successMessage);
            request.setAttribute("errorMessage", errorMessage);
            requestDispatcher = request.getRequestDispatcher("/vul/searchMain.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            requestDispatcher = request.getRequestDispatcher("/error404.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
