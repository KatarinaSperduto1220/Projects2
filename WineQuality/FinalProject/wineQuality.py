# wine_quality.py
# Quality ranges from 3 to 9

# import libraries
import numpy as np
import pandas as pd
import tensorflow as tf
from sklearn.preprocessing import LabelBinarizer
from sklearn.preprocessing import Normalizer
from sklearn.metrics import confusion_matrix
import keras
import matplotlib.patches as mpatches
from keras.models import Sequential
from keras.layers import Dense
import matplotlib.pyplot as plt
import ipdb

# fix seed
np.random.seed(3000)

# Load Dataset
# Full dataset
full_dataframe = pd.read_csv("winequalityN2.csv", header = None)
full_dataset = full_dataframe.values

# red dataset
red_train = pd.read_csv("redTrain(CSV).csv", header = None)
red_train_set = red_train.values
red_test = pd.read_csv("redTest(CSV).csv", header = None)
red_test_set = red_test.values

# white dataset
white_train = pd.read_csv("whiteTrain(CSV).csv", header = None)
white_train_set = white_train.values
white_test = pd.read_csv("whiteTest(CSV).csv", header = None)
white_test_set = white_test.values

# Declare/Seperate Data
full_type = full_dataset[1:,0]
full_quality = full_dataset[1:,12].astype('int')
full_X = full_dataset[1:,1:12].astype('float32')


red_train_quality = red_train_set[1:,12]
red_test_quality = red_test_set[1:,12]
red_train_X = red_train_set[1:,1:12].astype('float32')
red_test_X = red_test_set[1:,1:12].astype('float32')


white_train_quality = white_train_set[1:,12]
white_test_quality = white_test_set[1:,12]
white_train_X = white_train_set[1:,1:12].astype('float32')
white_test_X = white_test_set[1:,1:12].astype('float32')

# Normalize data
transformer = Normalizer().fit(full_X)
normalized_full_X = transformer.transform(full_X)

# Place labels into categories
full_quality -= 3
full_quality1 = tf.keras.utils.to_categorical(full_quality,7)

red_test_quality -= 3
red_train_quality -= 3
red_train_quality1 = tf.keras.utils.to_categorical(red_train_quality,7)
red_test_quality1 = tf.keras.utils.to_categorical(red_test_quality,7)

white_test_quality -= 3
white_train_quality -= 3
white_train_quality1 = tf.keras.utils.to_categorical(white_train_quality,7)
white_test_quality1 = tf.keras.utils.to_categorical(white_test_quality,7)

# Set the batch size and epochs
batch_size = 100
epochs = 2000
learning_rate = 0.001


# Creation of te NN
model1 = Sequential()
model1.add(Dense(units=100, activation='relu',input_dim=11))
model1.add(Dense(units=100, activation='relu'))
model1.add(Dense(units=100, activation='relu'))
model1.add(Dense(units=100, activation='relu'))
model1.add(Dense(units=100, activation='relu'))
model1.add(Dense(units=7, activation='softmax'))
model1.summary()

sgd= keras.optimizers.SGD(lr=learning_rate)
model1.compile(loss='mean_squared_error', optimizer = 'adam',metrics=['accuracy'])

# Train NN
model1.fit(
    normalized_full_X, full_quality1,
    batch_size = batch_size,
    epochs = epochs,
    verbose = 2

)

# Predict the qualities
pred1 = model1.predict(normalized_full_X)
score1 = model1.evaluate(normalized_full_X, full_quality1, verbose = 0)


print("Test loss Full DataSet: ", score1[0])
print("Test accuracy Full DataSet: ", score1[1])
test1 = pred1.argmax(1)+1
print(test1)

# confusion matrix
cm1 = confusion_matrix(full_quality, test1)
print(cm1)
