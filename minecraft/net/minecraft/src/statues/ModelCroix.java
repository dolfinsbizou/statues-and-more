/**
 * Model Techne class for the cross statue
 */

package net.minecraft.src.statues;

import net.minecraft.src.*;

public class ModelCroix extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    
    public ModelCroix()
    {
    	textureWidth = 64;
    	textureHeight = 64;
    	
    	Shape1 = new ModelRenderer(this, 0, 0);
    	Shape1.addBox(0F, 0F, 0F, 2, 32, 2);
    	Shape1.setRotationPoint(-1F, -16F, -1F);
    	Shape1.setTextureSize(64, 32);
    	Shape1.mirror = true;
    	setRotation(Shape1, 0F, 0F, 0F);
    	
    	Shape2 = new ModelRenderer(this, 8, 0);
    	Shape2.addBox(0F, 0F, 0F, 16, 2, 2);
    	Shape2.setRotationPoint(-8F, -8F, -1F);
    	Shape2.setTextureSize(64, 32);
    	Shape2.mirror = true;
    	setRotation(Shape2, 0F, 0F, 0F);
    }
    
    /**
	 * Render a static model as defined in the constructor
	 */
    public void renderModel (float f)
    {
    	Shape1.render(f);
    	Shape2.render(f);
    }
    
    /**
	 * Sets the models various rotation angles then renders the model.
	 */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	Shape1.render(f5);
    	Shape2.render(f5);
    }
    
    /**
	 * Sets the model rotation.
	 */
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
    
    /**
	 * Change the position of the statue depending of if there is a step or not.
	 */
    public void stepExists(boolean exists)
    {
    	if(!exists)
    	{
    		this.Shape1.rotationPointY = -8F;
    		this.Shape2.rotationPointY = 0F;
    	}
    	else
    	{
    		this.Shape1.rotationPointY = -16F;
    		this.Shape2.rotationPointY = -8F;
    	}
    }
}
