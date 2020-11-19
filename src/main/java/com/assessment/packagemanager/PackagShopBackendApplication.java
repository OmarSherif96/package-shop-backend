package com.assessment.packagemanager;

import com.assessment.packagemanager.dao.PackageRepository;
import com.assessment.packagemanager.dao.ProductRepository;
import com.assessment.packagemanager.model.Package;
import com.assessment.packagemanager.model.Product;
import com.assessment.packagemanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


@SpringBootApplication
public class PackagShopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagShopBackendApplication.class, args);
	}

	@Component
	class DemoCommandLineRunner implements CommandLineRunner {

		@Autowired
		private PackageRepository packageRepository;

		@Autowired
		private ProductService productService;

		private  final Logger logger = Logger.getLogger(getClass().getName());

		@Override
		public void run(String... args) throws Exception {

			logger.info("Initializing Database Metadata ");
			String packDescription="Package description  is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book";
			Package pack1 = new Package("Gold Package", packDescription, null);
			Package pack2 = new Package("Rare Package", packDescription, null);
			Package pack3 = new Package("Bronze Package", packDescription, null);
			Package pack4 = new Package("Silver Package", packDescription, null);
			Package pack5 = new Package("Champion Package", packDescription, null);
			Package pack6 = new Package("Warrior Package", packDescription, null);



			Product product1 = new Product("VqKb4tyj9V6i","Shield",1149.0);
			Product product2 = new Product("DXSQpv6XVeJm","Helmet",999.0);


			ArrayList<Product> productsList1 = new ArrayList<Product>();
			productsList1.add(product1);
			productsList1.add(product2);


			ArrayList<Product> productsList2 = new ArrayList<Product>();
			productsList2.add(product1);

			pack1.setProductsandFixPrices(productsList1);
			pack2.setProductsandFixPrices(productsList2);
			pack3.setProductsandFixPrices(productsList2);
			pack4.setProductsandFixPrices(productsList1);
			pack5.setProductsandFixPrices(productsList1);
			pack6.setProductsandFixPrices(productsList2);

			logger.info("Storing records in the database");
			List<Package> packages = Arrays.asList(pack1,pack2,pack3,pack4,pack5,pack6);
			packageRepository.saveAll(packages);
			logger.info("Stored succcessful");



		}


	}
}
