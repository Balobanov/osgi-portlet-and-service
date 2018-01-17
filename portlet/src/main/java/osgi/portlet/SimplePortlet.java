package osgi.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import osgi.simple.service.SimpleService;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=com.proliferay.demo Portlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class)
public class SimplePortlet extends MVCPortlet {

    private SimpleService simpleService;

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        super.doView(renderRequest, renderResponse);
    }

    @Override
    public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
        super.processAction(actionRequest, actionResponse);
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws IOException, PortletException {

        resourceResponse.setContentType("text/html");
        PrintWriter writer = resourceResponse.getWriter();
        writer.print(simpleService.doSome());
        writer.flush();
        writer.close();
        super.serveResource(resourceRequest, resourceResponse);
    }

    @Reference
    public void setSimpleService(SimpleService simpleService) {
        this.simpleService = simpleService;
    }
}
