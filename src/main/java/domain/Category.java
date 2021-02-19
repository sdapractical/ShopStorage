package domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;


public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long categoryId;
    private String title;
    @OneToMany(mappedBy = "category")
    private Set<Product> productList;

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId(){
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Product> getProductList() {
        return productList;
    }
}
