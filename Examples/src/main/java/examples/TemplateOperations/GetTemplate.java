package examples.TemplateOperations;

import com.groupdocs.cloud.parser.api.TemplateApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.Field;
import com.groupdocs.cloud.parser.model.Table;
import com.groupdocs.cloud.parser.model.Template;
import com.groupdocs.cloud.parser.model.TemplateOptions;
import com.groupdocs.cloud.parser.model.requests.GetTemplateRequest;

import examples.Common;
import examples.TemplateUtils;;

/**
 * This example demonstrates how to get template file from storage.
 */
public class GetTemplate {

	public static void main(String[] args) {

		// For example purposes create template if not exists.
		TemplateUtils.CreateIfNotExist("templates/template-for-companies.json");

		TemplateApi apiInstance = new TemplateApi(Common.GetConfiguration());

		try {
			TemplateOptions options = new TemplateOptions();
			options.setStorageName(Common.MyStorage);
			options.setTemplatePath("templates/template-for-companies.json");
			GetTemplateRequest request = new GetTemplateRequest(options);
			Template template = apiInstance.getTemplate(request);

			for (Field field : template.getFields()) {
				System.out.println("Field: " + field.getFieldName());
			}

			for (Table table : template.getTables()) {
				System.out.println("Field: " + table.getTableName());
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling TemplateApi:");
			e.printStackTrace();
		}
	}
}