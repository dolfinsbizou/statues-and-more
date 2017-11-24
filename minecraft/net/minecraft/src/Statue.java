package net.minecraft.src;

import java.util.Random;

public class Statue extends BlockContainer
{
	private Class Statue_EntityClass;
	   
   protected Statue(int i, Class tClass)
   
   {
	   super(i, Material.wood);
	   Statue_EntityClass = tClass;
   }
   
    public TileEntity getBlockEntity()
    {   
    	try
    	{
    		return (TileEntity)Statue_EntityClass.newInstance();
    	}

    	catch(Exception exception)
    	{
    		throw new RuntimeException(exception);
		}   
    }
   
   public int idDropped(int i, Random random, int j)
   {
      return mod_statue.itemStatue.shiftedIndex;
   }
      
   public int quantityDropped(Random random)
   {
      return 1;
   }
   
   public int getRenderType()
   {
      return -1;
   }

   public boolean isOpaqueCube()
   {
      return false;
   }
   
   public boolean renderAsNormalBlock()
   {
      return false;
   }
   
   public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
   {
	   //*
	   int i1 = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
	   int j1 = world.getBlockMetadata(i, j, k) & 4;
	   int k1 = 0;

       if (i1 == 0)
       {
    	   k1 = 0;
       }

       if (i1 == 1)
       {
    	   k1 = 1;
       }

       if (i1 == 2)
       {
    	   k1 = 2;
       }

       if (i1 == 3)
       {
           k1 = 3;
       }
       
       world.setBlockMetadataWithNotify(i, j, k, k1 | j1);
       //*/
   }
   
   public void onBlockPlaced(World world, int i, int j, int k, int par5)
   {
       if (par5 == 0)
       {
           int i1 = world.getBlockMetadata(i, j, k);
           world.setBlockMetadataWithNotify(i, j, k, i | 4);
       }
   }
   
   public boolean blockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
   {
       return true;
   }
}
