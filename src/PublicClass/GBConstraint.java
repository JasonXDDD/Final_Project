package PublicClass;

import java.awt.*;

/**
 * Created by JASON_ on 2015/5/25.
 */
public class GBConstraint extends GridBagConstraints {

    public GBConstraint(){
        super.fill = GridBagConstraints.BOTH;
        super.insets = new Insets(2,2,2,2);
    };

    public GridBagConstraints setValue(GridBagConstraints gbc, int x, int y, int height, int width){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridheight = height;
        gbc.gridwidth = width;


        return gbc;
    }

}
