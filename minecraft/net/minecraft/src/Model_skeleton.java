//Date: 12/05/2012 16:58:49
//Template version 1.1
//Java generated by Techne
//Keep in mind that you still need to fill in some blanks
//- ZeuX






package net.minecraft.src;

public class Model_skeleton extends ModelBase
{
//fields
  ModelRenderer jambe_droite;
  ModelRenderer jambe_gauche;
  ModelRenderer corps;
  ModelRenderer bras_droit;
  ModelRenderer bras_gauche;
  ModelRenderer tete;
  ModelRenderer chapeau;

public Model_skeleton()
{
    this(0.0F);
}
  
public Model_skeleton(float par1)
{
  textureWidth = 64;
  textureHeight = 32;
  
  jambe_gauche = new ModelRenderer(this, 0, 16);
  jambe_gauche.addBox(0F, 0F, 0F, 2, 12, 2, par1);
  jambe_gauche.setRotationPoint(1F, 4F, -2F);
  jambe_gauche.setTextureSize(64, 32);
  jambe_gauche.mirror = true;
  setRotation(jambe_gauche, 0F, 0F, 0F);
  jambe_droite = new ModelRenderer(this, 0, 16);
  jambe_droite.addBox(0F, 0F, 0F, 2, 12, 2, par1);
  jambe_droite.setRotationPoint(-3F, 4F, -2F);
  jambe_droite.setTextureSize(64, 32);
  jambe_droite.mirror = true;
  setRotation(jambe_droite, 0F, 0F, 0F);
  corps = new ModelRenderer(this, 16, 16);
  corps.addBox(0F, 0F, 0F, 8, 12, 4, par1);
  corps.setRotationPoint(-4F, -8F, -2F);
  corps.setTextureSize(64, 32);
  corps.mirror = true;
  setRotation(corps, 0F, 0F, 0F);
  bras_gauche = new ModelRenderer(this, 40, 16);
  bras_gauche.addBox(0F, 0F, 0F, 2, 12, 2, par1);
  bras_gauche.setRotationPoint(4F, -8F, -2F);
  bras_gauche.setTextureSize(64, 32);
  bras_gauche.mirror = true;
  setRotation(bras_gauche, 0F, 0F, 0F);
  bras_droit = new ModelRenderer(this, 40, 16);
  bras_droit.addBox(0F, 0F, 0F, 2, 12, 2, par1);
  bras_droit.setRotationPoint(-6F, -8F, -2F);
  bras_droit.setTextureSize(64, 32);
  bras_droit.mirror = true;
  setRotation(bras_droit, 0F, 0F, 0F);
  tete = new ModelRenderer(this, 0, 0);
  tete.addBox(0F, 0F, 0F, 8, 8, 8, par1);
  tete.setRotationPoint(-4F, -16F, -4F);
  tete.setTextureSize(64, 32);
  tete.mirror = true;
  setRotation(tete, 0F, 0F, 0F);
  chapeau = new ModelRenderer(this, 32, 0);
  chapeau.addBox(0F, 0F, 0F, 8, 8, 8, par1+0.5F);
  chapeau.setRotationPoint(-4F, -16F, -4F);
  chapeau.setTextureSize(64, 32);
  chapeau.mirror = true;
  setRotation(chapeau, 0F, 0F, 0F);
}

public void renderModel(float f)
{
      bras_gauche.render(f);
      bras_droit.render(f);
      jambe_gauche.render(f);
      jambe_droite.render(f);
      corps.render(f);
      tete.render(f);
      chapeau.render(f);
}

public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
{
  super.render(entity, f, f1, f2, f3, f4, f5);
  setRotationAngles(f, f1, f2, f3, f4, f5);
  jambe_gauche.render(f5);
  jambe_droite.render(f5);
  corps.render(f5);
  bras_gauche.render(f5);
  bras_droit.render(f5);
  tete.render(f5);
  chapeau.render(f5);
}

private void setRotation(ModelRenderer model, float x, float y, float z)
{
  model.rotateAngleX = x;
  model.rotateAngleY = y;
  model.rotateAngleZ = z;
}

public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
{
  super.setRotationAngles(f, f1, f2, f3, f4, f5);
}

}
