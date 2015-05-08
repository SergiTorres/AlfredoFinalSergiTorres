package com.example.library;

import com.example.library.Model.*;
import com.example.library.Repositories.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
@EnableJpaRepositories
public class SpringDataExampleLibraryApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringDataExampleLibraryApplication.class, args);

	    /*CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);


	    // save a couple of categories
	    Category firstCategory = categoryRepository.save(Category.from("Parent Category 1", null, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Child Category 1", firstCategory, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Child Category 2", firstCategory, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Parent Category 2", null, new ArrayList<Item>()));
	    Category secondCategory = categoryRepository.save(Category.from("Parent Category 3", null, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Child Category 3", secondCategory, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Child Category 4", secondCategory, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Child Category 5", secondCategory, new ArrayList<Item>()));

	    // save a couple of items
	    especialidadRepository.save(Item.from("Item 1", null));
	    especialidadRepository.save(Item.from("Item 2", firstCategory));
	    especialidadRepository.save(Item.from("Item 3", firstCategory));
	    especialidadRepository.save(Item.from("Item 4", secondCategory));
	    especialidadRepository.save(Item.from("Item 5", secondCategory));
	    especialidadRepository.save(Item.from("Item 6", secondCategory));*/

        ProyectoRepository proyectoRepository = context.getBean(ProyectoRepository.class);
        DeveloperRepository developerRepository = context.getBean(DeveloperRepository.class);
		EspecialidadRepository especialidadRepository = context.getBean(EspecialidadRepository.class);
		ManagerRepository managerRepository = context.getBean(ManagerRepository.class);

	    /*Author author = new Author();
	    author.setFirstName("Jane");
	    author.setLastName("Doe");
	    author.setBirthDate(new Date());
	    //proyectoRepository.save(author);

	    Book book = new Book();
	    book.setTitle("Spring");
	    book.setIsbn("1234567891");
	    book.setNumSells(1000);
	    book.setPublishedDate(new Date());

	    //book.getAuthors().add(author);
	    developerRepository.save(book);

	    author.getBooks().add(book);
	    proyectoRepository.save(author);*/

        Calendar c1 = GregorianCalendar.getInstance();

        c1.set(GregorianCalendar.YEAR, 2015);
        c1.set(GregorianCalendar.MONTH, 8);
        c1.set(GregorianCalendar.DATE, 18);

        Date d1 = c1.getTime();


        Proyecto proyecto1 = new Proyecto();
        proyecto1.setDescripcion("Proyecto 1, practica jquery");
        proyecto1.setFechaInicio(new Date());
        proyecto1.setFechaFin(d1);

		proyectoRepository.save(proyecto1);

		Developer developer2 = new Developer();
		developer2.setName("Ramon Rodrigues");
		developer2.setDni("456372892K");
		developer2.setCategoria("Senior");

		developerRepository.save(developer2);

		Manager manager2 = new Manager();
		manager2.setName("Pepe Purillos");
		manager2.setDni("128572392K");

		managerRepository.save(manager2);




		Especialidad especialidad1 = new Especialidad();
		especialidad1.setName("PHP");

		especialidadRepository.save(especialidad1);

		//proyecto1.getDevelopers().add(developer2);
		//proyectoRepository.save(proyecto1);
		developer2.getEspecialidades().add(especialidad1);
		proyecto1.getDevelopers().add(developer2);
		developerRepository.save(developer2);

		proyecto1.getEspecialidades().add(especialidad1);
		especialidadRepository.save(especialidad1);
		proyectoRepository.save(proyecto1);
		/*proyecto1.getDevelopers().add(developer1);*/


    }
}
