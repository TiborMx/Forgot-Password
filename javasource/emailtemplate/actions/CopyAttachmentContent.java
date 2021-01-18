// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package emailtemplate.actions;

import java.io.InputStream;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

public class CopyAttachmentContent extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject __CopyFrom;
	private system.proxies.FileDocument CopyFrom;
	private IMendixObject __CopyTo;
	private system.proxies.FileDocument CopyTo;

	public CopyAttachmentContent(IContext context, IMendixObject CopyFrom, IMendixObject CopyTo)
	{
		super(context);
		this.__CopyFrom = CopyFrom;
		this.__CopyTo = CopyTo;
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.CopyFrom = __CopyFrom == null ? null : system.proxies.FileDocument.initialize(getContext(), __CopyFrom);

		this.CopyTo = __CopyTo == null ? null : system.proxies.FileDocument.initialize(getContext(), __CopyTo);

		// BEGIN USER CODE
		IContext context = this.getContext();

		InputStream filedocumentObj = Core.getFileDocumentContent(this.getContext(), this.CopyFrom.getMendixObject());

		String filename = this.CopyFrom.getName();

		Core.storeFileDocumentContent(context, this.CopyTo.getMendixObject(), filename, filedocumentObj);

		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "CopyAttachmentContent";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
