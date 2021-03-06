package breaking_dependency.construction_blob.before;


/**
 * If a constructor constructs a large number of objects internally or accesses a large number of globals, we
 * could end up with a very large parameter list. In worse situations, a constructor
 * creates a few objects and then uses them to create other objects, like this:
 */
public class WatercolorPane {
    private FocusWidget cursor;


    public WatercolorPane(Form border, WashBrush brush, Pattern backdrop){
        Panel anteriorPanel = new Panel(border);
        anteriorPanel.setBorderColor(brush.getForeColor());
        Panel backgroundPanel = new Panel(border, backdrop);
        /*
            If we want to sense through the cursor, we are in trouble. The cursor object
            is embedded in a blob of object creation.
         */
        cursor = new FocusWidget(brush, backgroundPanel);
    }
}
