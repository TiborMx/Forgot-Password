// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package emailtemplate.actions;

import java.io.IOException;
import java.io.StringReader;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

/**
 * Provide a html string as input, the action will strip off all html elements and returns a plain text to 
 */
public class ConvertHTMLBodyToPlainText extends CustomJavaAction<java.lang.String>
{
	private java.lang.String HTMLBody;

	public ConvertHTMLBodyToPlainText(IContext context, java.lang.String HTMLBody)
	{
		super(context);
		this.HTMLBody = HTMLBody;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		return ConvertHTMLBodyToPlainText.removeHTML(this.HTMLBody);
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "ConvertHTMLBodyToPlainText";
	}

	// BEGIN EXTRA CODE
	public static String removeHTML(String htmlString) throws IOException
	{
		if (htmlString == null)
			return "";
		final StringBuffer result = new StringBuffer();
			
		HTMLEditorKit.ParserCallback callback = 
				new HTMLEditorKit.ParserCallback () {
			@Override
			public void handleText(char[] data, int pos) {
				result.append(data); //TODO: needds to be html entity decode?
			}
		
			@Override
			public void handleComment(char[] data, int pos) {
				//Do nothing
			}
		
			@Override
			public void handleError(String errorMsg, int pos) {
				//Do nothing
			}
		
			@Override
			public void handleSimpleTag(HTML.Tag tag, MutableAttributeSet a, int pos) {
				if (tag == HTML.Tag.BR)
					result.append("\r\n");
			}
		
			@Override
			public void handleEndTag(HTML.Tag tag, int pos){
				if (tag == HTML.Tag.P)
					result.append("\r\n");
			}
		};
		
		new ParserDelegator().parse(new StringReader(htmlString), callback, true);
			
		return result.toString();
	}
	// END EXTRA CODE
}
