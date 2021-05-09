package Pojo;

import java.util.List;

public class Ppet{

    private int id;
    private Pcategory category;
    private String name;
    private List<String> photoUrls;
    private List<Ptag> tags;
    private String status;

    public Ppet(int id, Pcategory category, String name, List<String> photoUrls, List<Ptag> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pcategory getCategory() {
        return category;
    }

    public void setCategory(Pcategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Ptag> getTags() {
        return tags;
    }

    public void setTags(List<Ptag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
