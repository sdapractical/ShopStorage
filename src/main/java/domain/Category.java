package domain;

import java.util.List;

public class Category {
    private long id;
    private String title;
    private List<Product> productList;

    public long getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
