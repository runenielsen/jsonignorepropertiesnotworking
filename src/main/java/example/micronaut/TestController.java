package example.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class TestController {

    @Get("/test")
    public HttpResponse<BasicBookInfo> getTest() {
        return HttpResponse.ok(new BasicBookInfo("Michael Ende", "The Neverending Story", BookInfo.TypeEnum.BASIC));
    }
}
