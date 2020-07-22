package vn.itsol.MSWallet.dto;

import javax.persistence.Column;

public class CategoryDto
{
    private long categoryid;
    private String categoryName;

    public long getCategoryid() {
        return categoryid;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryid(long category) {
        this.categoryid = category;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryDto(long category, String categoryName) {
        this.categoryid = category;
        this.categoryName = categoryName;
    }

    public CategoryDto() {
    }
}
