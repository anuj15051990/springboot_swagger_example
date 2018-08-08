package fitchrating.springframework.bootstrap;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import fitchrating.springframework.domain.Product;
import fitchrating.springframework.repositories.ProductRepository;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;


    private Logger log = LogManager.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
    }

    private void loadProducts() {
        Product shirt = new Product();
        shirt.setDescription("Sample");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("sample.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("sample testing - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Sample code");
        mug.setImageUrl("sampleurl.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Sample testing - id:" + mug.getId());
    }


    }



