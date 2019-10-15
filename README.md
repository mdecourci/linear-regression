# Train a model to predict the Boston Housing dataset

# Spark ML
The idea is to distribute the calculations to multiple low-end machines (commodity hardware) instead of a single high-end one. 
This will definitely speed up the learning phase and allows us to create better model

## DataSet

<https://www.cs.toronto.edu/~delve/data/boston/bostonDetail.html>

The dataset is small in size with only 506 cases. It contains 14 features described as follows:
* CRIM: per capita crime rate by town
* ZN: proportion of residential land zoned for lots over 25,000 sq.ft.
* INDUS: proportion of non-retail business acres per town.
* CHAS: Charles River dummy variable (1 if tract bounds river; 0 otherwise)
* NOX: nitric oxides concentration (parts per 10 million)
* RM: average number of rooms per dwelling
* AGE: proportion of owner-occupied units built prior to 1940
* DIS: weighted distances to five Boston employment centres
* RAD: index of accessibility to radial highways
* TAX: full-value property-tax rate per $10,000
* PTRATIO: pupil-teacher ratio by town
* B: 1000(Bk — 0.63)² where Bk is the proportion of blacks by town
* LSTAT: % lower status of the population
* MEDV: Median value of owner-occupied homes in $1000's

The goal is to use the 13 features to predict the value of MEDV (which represents the housing price).

## Model 
The dataset was split so that 70% represents training data and 30% test data.  
There was insuffient data to get good fit with a split of 70% = training data,20% = test data and 10% = verify data
revisit?