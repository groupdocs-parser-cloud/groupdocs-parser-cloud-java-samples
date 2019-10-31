package examples.TemplateOperations;

import com.groupdocs.cloud.parser.api.TemplateApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.TemplateOptions;
import com.groupdocs.cloud.parser.model.requests.DeleteTemplateRequest;

import examples.Common;
import examples.TemplateUtils;;

/**
 * This example demonstrates how to delete template file from storage.
 */
public class DeleteTemplate {

	public static void main(String[] args) {

		// For example purposes create template if not exists.
		TemplateUtils.CreateIfNotExist("templates/template-for-companies.json");

		TemplateApi apiInstance = new TemplateApi(Common.GetConfiguration());

		try {
			TemplateOptions options = new TemplateOptions();
			options.setStorageName(Common.MyStorage);
			options.setTemplatePath("templates/template-for-companies.json");
			DeleteTemplateRequest request = new DeleteTemplateRequest(options);
			apiInstance.deleteTemplate(request);
			System.out.println("Done.");
		} catch (ApiException e) {
			System.err.println("Exception while calling TemplateApi:");
			e.printStackTrace();
		}
	}
}