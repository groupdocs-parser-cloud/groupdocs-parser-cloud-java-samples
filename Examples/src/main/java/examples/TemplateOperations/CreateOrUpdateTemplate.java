package examples.TemplateOperations;

import com.groupdocs.cloud.parser.api.TemplateApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.CreateTemplateOptions;
import com.groupdocs.cloud.parser.model.Template;
import com.groupdocs.cloud.parser.model.TemplateResult;
import com.groupdocs.cloud.parser.model.requests.CreateTemplateRequest;

import examples.Common;
import examples.TemplateUtils;

/**
 * This example demonstrates how to save template file in storage.
 */
public class CreateOrUpdateTemplate {

	public static void main(String[] args) {

		TemplateApi apiInstance = new TemplateApi(Common.GetConfiguration());

		try {
			CreateTemplateOptions options = new CreateTemplateOptions();
			Template template = TemplateUtils.GetTemplate();
			options.setTemplate(template);
			options.setStorageName(Common.MyStorage);
			options.setTemplatePath("templates/template-for-companies.json");
			CreateTemplateRequest request = new CreateTemplateRequest(options);
			TemplateResult response = apiInstance.createTemplate(request);

			System.out.println("Path to saved template in storage: " + response.getTemplatePath());
			System.out.println("Link to download template: " + response.getUrl());
		} catch (ApiException e) {
			System.err.println("Exception while calling TemplateApi:");
			e.printStackTrace();
		}
	}
}