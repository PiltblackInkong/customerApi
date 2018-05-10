package com.chakhrit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

public class CORSFilter extends GenericFilterBean implements Filter {



@Override
public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)
throws IOException,ServletExpection {
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    httpResponse.setHander (name: "Access-Control-Allow-origin", value: "*");
    httpResponse.setHander (name: "Access-Control-Allow-Methods", value:"*");
    //httpResponse.setHander ("Access-Control-Allow-Methods","POST,GET,PUT,OPTIONs,DELETE");

    httpResponse.setHander(name: "Access-Control-Allow-Headers", value: "*");
   // httpResponse.setHander("Access-Control-Allow-Headers","Origin,X-Requested-With,Content-Type,Accept,X-Auth-Token,X-Csrf-Token,Authorization");

httpResponse.setHander(name: "Access-Control-Allow-Credentials", value:"false");
httpResponse.setHander(name: "Access-Control-Aloow-Max-Age", value:"3600");

System.out.println("********** CORS configuration Completed **********");

chain.doFilter(request, response);
}
}//The End
