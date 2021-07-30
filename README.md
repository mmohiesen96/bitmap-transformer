# bitmap-transformer


## The input(args) parameters like

  (transName, outPutPath , inPutPath)

- We have multiple transformer :

1- AddSingleColorBorder :

- you can add Cyan OR Orange border by

 1. transName = "cyanBorder"
 2. transName = "OrangeBorder"

2- AddTwoColorBorder :  first color on x axis and the second color on y axis

* transName = "twoColorBorder"

3- AddMagentaAndCyanBorder

* transName = "magentaAndCyanBorder"

4- filter with Blue

* transName = "filter"

### A small program to read in an image and transform it with 3 different choices :

#### Filter Blue color : Removes the blue color of an image . (no param)

#### Add a border : Adds a border to the image . (no param)

#### Filter the green Color : removes a green color from an image .  (no param)

