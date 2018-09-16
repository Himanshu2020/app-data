package musipo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  @RequestMapping("/")
  @ResponseBody
  public String index() {
    String userID = "esADtxEVwiU:APA91bFacDtOnEXFwe0I0PfPdt6WhtX7bqxnaCLMLQ0BI2V_vtdzxgtikc7fJCjCJCrVHt_Eu9iMZirGghJHY8evs97YyAqUhWF1rhV7GhjfiaVuFdx9V3oOHhnxSwRd2A9TEmih_RgC";

    try {
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "Proudly handcrafted by " +
        "<a href='http://netgloo.com/en'>netgloo</a> :)";
  }

  @RequestMapping("/hi")
  public @ResponseBody String hiThere(){
    return "hello world!";
  }

}




