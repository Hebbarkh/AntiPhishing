# Licence Plate Recognition

An application to detect the licence plate of a vehicle and recognise the letters. The model uses python scikit-image to process the image and SVM model from the python scikit-learn to detect the number plate.

## Prerequisites

python 3.3+ with following packages


python3-scikit-image

python3-scikit-learn


## Installation
```
sudo apt-get -y install python3-pip

pip3 install scikit-learn

pip3 install scikit-image
```

RUN `Licence_plate.py` file


## Description

The Application recognises the licence plate number of a vehicle. It uses the property of neighbourhood of pixels in an image to detect the licence plate. The image is converted into binary and licence plate of the vehicle is detected by selecting a connected component that has the approximate image to licence plate ratio. The plate is further divide into digits by using the 8-connected property of the digits.

A SVM model is trained by using the python scikit-learn package. The training data set contains 10 samples of each letter and digits. Each fragmented digit is run through the model to recognise the letter.
