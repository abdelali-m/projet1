import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import gestionFilmSpringMvc.controller.FilmController;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//SilmContoller control = new SilmContoller();
		//control.registrefilmfromconsole();
        FilmController controller =(FilmController) context.getBean("filmController");
        controller.registrefilmfromconsole();
	}

}
