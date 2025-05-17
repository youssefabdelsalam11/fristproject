package DrawableProject;

public abstract class ThreeDShape extends Shape {
	 public ThreeDShape() {
	        super();
	    }

	    public ThreeDShape(String color) {
	        super(color);
	    }

	    public double getVolume() {
	        return 0;
	    }

	    @Override
	    public String howToDraw() {
	        return "ThreeDShape";
	    }
	}


