# KidsGame

### Android app-game for kids that helps to develop their mind and logic abiities :D

## Design 
Before starting app building the prototype was created in Figma 

[Click here to see a Figma working place](https://www.figma.com/file/fPsKapQJin0kJZDRwIYY4q/kids-gamef?node-id=0%3A1)

[Click here to see a ready Figma prototype](https://www.figma.com/proto/fPsKapQJin0kJZDRwIYY4q/kids-gamef?node-id=1%3A2&viewport=675%2C-13%2C0.125&scaling=scale-down).

Screenshots below represent game main screens. Game consists of 10 levels which are devided into two logical tasks. First is choosing something that is greater, smaller, faster etc. 
Second is choosing something by any criteria, like "eatable and not eatable" etc.

![start page](https://imgur.com/E8kVBrj.png)
![levels page](https://imgur.com/0FfkdTL.png)
![levels page](https://imgur.com/eitmTv2.png)

When a user first time opens the app, he will be able to see all game levels that are not available for him untill he wins the previous level. After successful finishing a level, 
second one opens automatically. In case the user closes the app, all data keeps saved because of using Shared Preferences.

Each level begins with a preview dialog that contains level description. In case of corect choosing the answer will be replaced with a correct mark picture, vice versa incorrect
choice will be replaced with incorrect mark picture.Every time image choices appear in a random sequence because of importing Random library. When user finishes the game(after collecting 20 points only!) 
the end level preview dialog appears and asks user to continue the game with next level.
(all these you can see at images below). After finishing the 10th level preview dialog informs a user about succedssfull game finishing.


![level one preview](https://imgur.com/UDXcysM.png)
![level one start](https://imgur.com/ioKO44k.png)
![level one correct](https://imgur.com/rYxiX42.png)
![level one incorrect](https://imgur.com/cktKuUW.png)
![level one end](https://imgur.com/Xunsy17.png)
![game end](https://imgur.com/93sXg2S.png)



