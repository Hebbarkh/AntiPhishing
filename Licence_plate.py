import numpy as np
from skimage.io import imread, imsave,imshow
from skimage.measure import label,regionprops
from skimage.transform import resize
from skimage.morphology import closing, square
from skimage.filters import threshold_otsu,threshold_mean
from skimage import restoration
from skimage.util import invert
import matplotlib.pyplot as plt
import matplotlib.patches as patches
from skimage import exposure
import pandas as pd
import SVM


model = SVM.svm_model()


def test(img):
	global model
	testImg = np.reshape(img, (1,-1))
	z=model.predict(testImg)
	print(z)
	return z


def read_img():
	global img
	img=imread("test_samples/car.jpeg",as_grey=True)
	img1=imread("test_samples/car.jpeg")
	imshow(img1)
	plt.show()

def process_image():
	read_img()
	bin_img=img>=threshold_otsu(img)
	cc = label(bin_img)

	imshow(bin_img)
	plt.show()
	fig, (ax1) = plt.subplots(1)
	ax1.imshow(img, cmap="gray");
	num_plate=[]
	dim = []
	for region in regionprops(cc):
	        if region.area>100:
	                minr,minc,maxr,maxc=region.bbox
	                width_ratio=(maxc-minc)/np.shape(bin_img)[1]
	                height_ratio=(maxr-minr)/np.shape(bin_img)[0]
	                if .2 <= width_ratio <= .5 and .02 <= height_ratio <= .3:
	                	rectBorder = patches.Rectangle((minc, minr), maxc-minc, maxr-minr, edgecolor="red", linewidth=2, fill=False)
	                	ax1.add_patch(rectBorder)
	                	num_plate.append(bin_img[minr:maxr,minc:maxc])
	                	dim.append([minr,minc,maxr,maxc])

	plt.show()
	i=0
	k=0
	for cc in num_plate:
		cc=invert(cc)
		cca=label(cc)
		nump=[]
		for region in regionprops(cca):
			minr,minc,maxr,maxc=region.bbox
			width_ratio=(maxc-minc)/np.shape(cc)[1]
			height_ratio=(maxr-minr)/np.shape(cc)[0]
			if .02 <= width_ratio <= .2 and .5 <= height_ratio <= .8:
				minr+=dim[i][0]
				minc+=dim[i][1]
				maxr+=dim[i][0]
				maxc+=dim[i][1]
				imgg=img[minr:maxr,minc:maxc]>threshold_otsu(img[minr:maxr,minc:maxc])
				
				imshow(imgg)
				plt.show()
				imgg = resize(imgg,(20,20))			
				nump.append(test(imgg)[0])			
		i+=1
		if len(nump)>3:
			print("Recognized Number Plate:\t",''.join(nump))
if __name__ == '__main__':
	process_image()
