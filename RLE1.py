from PIL import Image
img = Image.open("butterfly_8bit.bmp")
orgimg = list(img.getdata(0))
print(img.mode)
