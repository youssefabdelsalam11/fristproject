package DrawableProject;
import java.util.Date;
public abstract class Shape implements Drawable {
    private Date dateCreated;
    private String color;

    public Shape() {
        dateCreated = new Date();
        color = "Default";
    }

    public Shape(String color) {
        dateCreated = new Date();
        this.color = color;
    }

    public Date getDateCreated() {
        return dateCreated;
    }


    public abstract double getArea();

    public abstract double getPerimeter();

    public String getColor() { return color; }

    public void setColor(String color){
    	this.color = color; 
    	}




}