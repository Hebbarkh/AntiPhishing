from sklearn.svm import SVC
from sklearn.externals import joblib
from sklearn.neighbors import KNeighborsClassifier
from skimage.io import imread, imsave,imshow
from skimage.transform import resize
from skimage import restoration
from skimage.util import invert
from skimage.filters import threshold_otsu,threshold_mean
import numpy as np

imageData = []
targetData = []
imgListDir = "training_data/"
def readandpreprocess(imageDir):
    imageDetails = imread(imageDir, as_grey=True)
    imageDetails = resize(imageDetails,(20,20))
    imageDetails = invert(imageDetails)
    imageDetails = restoration.denoise_tv_chambolle(imageDetails, weight=0.4)
    return imageDetails < threshold_otsu(imageDetails)

def svm_model():
 lettersDict =    {'0':10,'1':10,'2':10,'3':10,'4':10,'5':10,'6':10,'7':10,'8':10,'9':10,
 'A':10,'B':10,'C':10,'D':10,'E':10,'F':10,'G':10,'H':10,'J':10,'K':10,'L':10,'M':10,'N':10,
 'P':10,'Q':10,'R':10,'S':10,'T':10,'U':10,'V':10,'W':10,'X':10,'Y':10,'Z':10}
 letters = list(lettersDict.keys())

 count=0;
 for each in letters:
    eachGroupDir = imgListDir+each+'/'
    for aTraining in range(lettersDict[each]):
    	try:
        	eachTrainingImg = eachGroupDir+each+'_'+str(aTraining)+'.jpg'
        	letterDetails = readandpreprocess(eachTrainingImg)
    	except FileNotFoundError:
        	eachTrainingImg = eachGroupDir+each+'_'+str(aTraining)+'.png'
        	letterDetails = readandpreprocess(eachTrainingImg)
    	binaryImg = np.reshape(letterDetails, -1)
    	imageData.append(binaryImg)
    	targetData.append(each)
    count += 1
 global model
 model = SVC(gamma=0.001)

 model.fit(imageData, targetData)
 return model
