package examples;

import java.util.Arrays;
import java.util.List;

import com.groupdocs.cloud.parser.api.StorageApi;
import com.groupdocs.cloud.parser.api.TemplateApi;
import com.groupdocs.cloud.parser.model.CreateTemplateOptions;
import com.groupdocs.cloud.parser.model.DetectorParameters;
import com.groupdocs.cloud.parser.model.Field;
import com.groupdocs.cloud.parser.model.FieldPosition;
import com.groupdocs.cloud.parser.model.Point;
import com.groupdocs.cloud.parser.model.Rectangle;
import com.groupdocs.cloud.parser.model.Size;
import com.groupdocs.cloud.parser.model.Table;
import com.groupdocs.cloud.parser.model.Template;
import com.groupdocs.cloud.parser.model.requests.CreateTemplateRequest;
import com.groupdocs.cloud.parser.model.requests.ObjectExistsRequest;

import examples.Common;

public class TemplateUtils{
	public static void CreateIfNotExist(String path) {
		StorageApi storageApi = new StorageApi(Common.GetConfiguration());
		TemplateApi templateApi = new TemplateApi(Common.GetConfiguration());
		
		try {
			
			ObjectExistsRequest request = new ObjectExistsRequest(path,Common.MyStorage, null);
			if(storageApi.objectExists(request).getExists()) {
				return;
			}
			
			CreateTemplateOptions options = new CreateTemplateOptions();
			Template template = GetTemplate();
			options.setTemplate(template);
			options.setStorageName(Common.MyStorage);
			options.setTemplatePath(path);
			
			CreateTemplateRequest createRequest = new CreateTemplateRequest(options);
			templateApi.createTemplate(createRequest);
			
		}catch (Exception e) {
			System.err.println("Exception while calling TemplateApi:");
			e.printStackTrace();
		}
	}
	
	public static Template GetTemplate() {
		Field field1 = new Field();
        field1.setFieldName("Address");
        FieldPosition fieldPosition1 = new FieldPosition();
        fieldPosition1.setFieldPositionType("Regex");
        fieldPosition1.setRegex("Company address:");
        field1.setFieldPosition(fieldPosition1);

        Field field2 = new Field();
        field2.setFieldName("CompanyAddress");
        FieldPosition fieldPosition2 = new FieldPosition();
        fieldPosition2.setFieldPositionType("Linked");
        fieldPosition2.setLinkedFieldName("ADDRESS");
        fieldPosition2.setIsRightLinked(true);
        Size size2 = new Size();
        size2.setWidth(100d);
        size2.setHeight(10d);
        fieldPosition2.setSearchArea(size2);
        fieldPosition2.setAutoScale(true);
        field2.setFieldPosition(fieldPosition2);

        Field field3 = new Field();
        field3.setFieldName("Company");
        FieldPosition fieldPosition3 = new FieldPosition();
        fieldPosition3.setFieldPositionType("Regex");
        fieldPosition3.setRegex("Company name:");
        field3.setFieldPosition(fieldPosition3);
        
        Field field4 = new Field();
        field4.setFieldName("CompanyName");
        FieldPosition fieldPosition4 = new FieldPosition();
        fieldPosition4.setFieldPositionType("Linked");
        fieldPosition4.setLinkedFieldName("Company");
        fieldPosition4.setIsRightLinked(true);
        Size size4 = new Size();
        size4.setWidth(100d);
        size4.setHeight(10d);
        fieldPosition4.setSearchArea(size4);
        fieldPosition4.setAutoScale(true);
        field4.setFieldPosition(fieldPosition4);

        Table table = new Table();
        table.setTableName("Companies");
        DetectorParameters detectorparams = new DetectorParameters();
        Rectangle rect = new Rectangle();
        Size size = new Size();
        size.setHeight(60d);
        size.setWidth(480d);
        Point position = new Point();
        position.setX(77d);
        position.setY(279d);
        rect.setSize(size);
        rect.setPosition(position);
        detectorparams.setRectangle(rect);
        table.setDetectorParameters(detectorparams);

        List<Field> fields = Arrays.asList(new Field[] { field1, field2, field3, field4 });
        List<Table> tables = Arrays.asList(new Table[] { table });
        Template template = new Template();
        template.setFields(fields);
        template.setTables(tables);

        return template;
	}
}