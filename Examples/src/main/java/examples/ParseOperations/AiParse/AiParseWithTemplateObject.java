package examples.ParseOperations.AiParse;

import com.groupdocs.cloud.parser.api.ParseApi;
import com.groupdocs.cloud.parser.client.ApiException;
import com.groupdocs.cloud.parser.model.AIParseOptions;
import com.groupdocs.cloud.parser.model.FileInfo;
import com.groupdocs.cloud.parser.model.requests.AIParseRequest;
import examples.Common;

/**
 * This example demonstrates how to use the AI Parse operation with a template that is defined
 * programmatically (as a plain Java object). The template object contains the fields that the AI
 * service should extract from the document.
 */
public class AiParseWithTemplateObject {

    /**
     * Simple POJO that represents the AI template. The property names correspond to the fields
     * the AI model will try to extract from the document.
     */
    public static class InvoiceTemplate {
        private String InvoiceNum;
        private String Date;
        private String Email;

        public InvoiceTemplate() {
            this.InvoiceNum = "";
            this.Date = "";
            this.Email = "";
        }

        public String getInvoiceNum() { return InvoiceNum; }
        public void setInvoiceNum(String invoiceNum) { this.InvoiceNum = invoiceNum; }

        public String getDate() { return Date; }
        public void setDate(String date) { this.Date = date; }

        public String getEmail() { return Email; }
        public void setEmail(String email) { this.Email = email; }
    }

    public static void main(String[] args) {
        // Initialise the Parse API with configuration (App SID / App Key).
        ParseApi parseApi = new ParseApi(Common.GetConfiguration());

        try {
            // ---------------------------------------------------------------------
            // Prepare file information – the document we want to analyse.
            // ---------------------------------------------------------------------
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFilePath("pdf/Invoice.pdf"); // adjust the path to a file existing in your storage
            fileInfo.setStorageName(Common.MyStorage);

            // ---------------------------------------------------------------------
            // Build the AI template – here we use a plain Java object.
            // ---------------------------------------------------------------------
            InvoiceTemplate template = new InvoiceTemplate();

            // ---------------------------------------------------------------------
            // Assemble AI parse options.
            // ---------------------------------------------------------------------
            AIParseOptions options = new AIParseOptions();
            options.setFileInfo(fileInfo);
            options.setTemplate(template); // template supplied as an object

            // ---------------------------------------------------------------------
            // Create request and invoke the API.
            // ---------------------------------------------------------------------
            AIParseRequest request = new AIParseRequest(options);
            Object result = parseApi.aIParse(request);

            // The API returns a generic Object (usually a map). Print its JSON representation.
            System.out.println("AI Parse result: " + result);
        } catch (ApiException e) {
            System.err.println("Exception while calling ParseApi:");
            e.printStackTrace();
        }
    }
}
