package qx.leizige.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author leizige
 * 2022/02/02
 * 使用Apache Camel将文件从一个文件夹路由到另一个文件夹
 */
public class FileCopier {

    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                //将文件从inbox路由到outbox
                from("file:D://inbox")
                        .to("file:D://outbox");
            }
        });

        context.start();
        Thread.sleep(3000);
        context.stop();
    }

}
