package shapebuilder;

import java.util.List;

public class SortingTechnique {
	
	/**
	 * Sorts shapes by their surface area in ascending order using Bubble Sort, then repaints the screen.
	 * @param shapePanel
	 */
	public static void sortBySurfaceArea(ShapePanel shapePanel) {
		List<Shape> shapes = shapePanel.getShapes();
        int numberOfShapes = shapes.size();
        for (int i = 0; i < numberOfShapes - 1; i++) {
            for (int j = 0; j < numberOfShapes - i - 1; j++) {
                if (shapes.get(j).compareTo(shapes.get(j + 1)) > 0) {
                    Shape temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
            }
        }
        repaintShapes(shapePanel);
    }
	
	private static void repaintShapes(ShapePanel shapePanel) {
		int x = ShapeFactory.SPACING;
		int y = ShapeFactory.SPACING;
		for (Shape shape : shapePanel.getShapes()) {
			shape.setX(x);
			shape.setY(y);
			x += shape.getWidth() + ShapeFactory.SPACING;
			y += shape.getHeight() + ShapeFactory.SPACING;
		}
		shapePanel.repaint();
	}
}
