package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class TileEntity_statue extends TileEntity implements IInventory
{
    private Minecraft mc;
    private ItemStack items[];
	private int buttonValue;
	private String textField1, textField2;
	public String skinURL;
	private String textField3;

    public TileEntity_statue()
    {
    	textField1 = "<player name>";
    	textField2 = "<skin url>";
    	textField3 = "";
    	buttonValue = 0;
        mc = (ModLoader.getMinecraftInstance());
        items = new ItemStack[6];
    }

    public int getSizeInventory()
    {
        return items.length;
    }

    public ItemStack getStackInSlot(int i)
    {
        return items[i];
    }

    public ItemStack decrStackSize(int i, int j)
    {
        if (items[i] != null)
        {
            if (items[i].stackSize <= j)
            {
                ItemStack itemstack = items[i];
                items[i] = null;
                onInventoryChanged();
                return itemstack;
            }

            ItemStack itemstack1 = items[i].splitStack(j);

            if (items[i].stackSize == 0)
            {
                items[i] = null;
            }

            onInventoryChanged();
            return itemstack1;
        }
        else
        {
            return null;
        }
    }

    public ItemStack getStackInSlotOnClosing(int i)
    {
        if (items[i] != null)
        {
            ItemStack itemstack = items[i];
            items[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        items[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }

        onInventoryChanged();
    }

    public String getInvName()
    {
        return "Statue";
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        items = new ItemStack[getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 0xff;

            if (j >= 0 && j < items.length)
            {
                items[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
        //*
        buttonValue = nbttagcompound.getInteger("buttonValue");
        textField1 = nbttagcompound.getString("textField1");
        textField2 = nbttagcompound.getString("textField2");
        textField3 = nbttagcompound.getString("textField3");//*/

    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        NBTTagList nbttaglist = new NBTTagList();

        for (byte byte0 = 0; byte0 < items.length; byte0++)
        {
            if (items[byte0] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", byte0);
                items[byte0].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbttagcompound.setTag("Items", nbttaglist);
        //*
        nbttagcompound.setInteger("buttonValue", buttonValue);
        nbttagcompound.setString("textField1", textField1);
        nbttagcompound.setString("textField2", textField2);
        nbttagcompound.setString("textField3", textField3);//*/
    }

    public int getInventoryStackLimit()
    {
        return 1;
    }

    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }

        return entityplayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
    }

    /**
     * Called when an the contents of an Inventory change, usually
     */
    public void onInventoryChanged()
    {
        worldObj.markBlockNeedsUpdate(xCoord, yCoord, zCoord);
    }

    public void openChest()
    {
    }

    public void closeChest()
    {
    }
    
    public int getSkin()
    {
		switch(buttonValue)
		{
		case 0:
		default:
			return mc.renderEngine.getTexture("/dolfinsbizou/massif.png");
		case 1:
			return 1;
		case 2:
			return mc.renderEngine.getTexture("/dolfinsbizou/statue.png");
		case 3:
			return mc.renderEngine.getTexture("/mob/zombie.png");
		case 4:
			if (getTextField1() != null && getTextField1().length() > 0)
	        {
	            skinURL = (new StringBuilder()).append("http://s3.amazonaws.com/MinecraftSkins/").append(getTextField1()).append(".png").toString();
	        }
			else
			{
				skinURL = "http://www.perdu.com";
			}
			return mc.renderEngine.getTextureForDownloadableImage(skinURL, "/dolfinsbizou/noweb.png");
		case 5:
			return mc.renderEngine.getTextureForDownloadableImage(getTextField2(), "/dolfinsbizou/noweb.png");
		case 6:
			return mc.renderEngine.getTexture("/mob/creeper.png");
		case 7:
			return mc.renderEngine.getTexture("/dolfinsbizou/croix.png");
		case 8:
			return mc.renderEngine.getTexture("/mob/skeleton.png");
		}
    }
    
    public void setButtonValue(int value)
    {
    	buttonValue = value;
    }

	public int getButtonValue()
	{
		return buttonValue;
	}

	public Minecraft getMc()
	{
		return mc;
	}

	public String getTextField1()
	{
		return textField1;
	}

	public void setTextField1(String textField1)
	{
		this.textField1 = textField1;
	}

	public String getSkinURL()
	{
		return skinURL;
	}
	
	public String getTextField2()
	{
		return textField2;
	}

	public void setTextField2(String textField2)
	{
		this.textField2 = textField2;
	}
    
	public String getTextField3()
	{
		return textField3;
	}

	public void setTextField3(String textField3)
	{
		this.textField3 = textField3;
	}
	
	public int getTextColor()
	{
		ItemStack stack = this.getStackInSlot(5);
		if(stack != null)
		{
			int i = MathHelper.clamp_int(stack.getItemDamage(), 0, 15);
			switch(i)
			{
			case 0: //inksac
			default:
				return 0x151010;
			case 1: //rose red
				return 0x902D2F;
			case 2: //catus green
				return 0x30411E;
			case 3: //cocoa beans
				return 0x4B2E1F;
			case 4: //lapis lazuli
				return 0x2E3882;
			case 5: //purple dye
				return 0x7838A3;
			case 6: //cyan dye
				return 0x2E758D;
			case 7: //light grey dye
				return 0x929292;
			case 8: //grey dye
				return 0x3B3B3B;
			case 9: //pink dye
				return 0xCE778F;
			case 10: //lime green dye
				return 0x38B94E;
			case 11: //dandelion yellow
				return 0xCEC14C;
			case 12: //light blue dye
				return 0x7291C8;
			case 13: //magenta dye
				return 0xAE41AE;
			case 14: //orange dye
				return 0xDB733E;
			case 15: //bone meal
				return 0xFBFBFB;
			}
		}
		else
		{
			return 0x000000;
		}
	}
}