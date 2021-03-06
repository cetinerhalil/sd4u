package sd4u.editor;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import sd4u.html.UrlConverter;
import javafx.collections.ObservableList;

//all slide names must be different

/**
 * This class provides all project with changings
 * @author H. Cetiner & Y.H. Kalayci
 */
public class ProjectSaver {

	public void save( ObservableList<CustomCellContent> list ){
		
		StringBuffer sb = new StringBuffer(getClass().getResource("/WebContent/SubjectA/SavedFiles/").toString());
		sb.replace(0, "file:/".length()-1, "");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		sb.append(dateFormat.format(date));
		
		File theDir = new File( UrlConverter.toJava( sb.toString() ) );

		// if the directory does not exist, create it
		if (!theDir.exists()) {
		    try{
		        theDir.mkdir();
		    } 
		    catch(SecurityException se){
		        //handle it
		    }
		}
		
		for(int i=0;i<list.size();i++)
			if( !list.get(i).title.equals(MainController.NEW_SLIDE) )
			{
				HTMLSaver.finish( list.get(i).htmlText,sb.toString()+"/"+list.get(i).title,HTMLSaver.PROJECT );
			}
		
		//HTMLSaver.finish(htmlEditor.getHtmlText(),sb.toString());
		
		//sb.append(".html");
		
	}
	
}
