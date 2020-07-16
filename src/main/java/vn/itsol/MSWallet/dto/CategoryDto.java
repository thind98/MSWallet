package vn.itsol.MSWallet.dto;

import javax.persistence.Column;

public class CategoryDto
{
    private long category;
    private String categoryName;

    public long getCategory() {
        return category;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategory(long category) {
        this.category = category;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "category=" + category +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
