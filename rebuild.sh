#!/usr/bin/env bash
#**************************************************************************** #
#                                                                              #
#                                                             |\               #
#    rebuild.sh                                         ------| \----          #
#                                                       |    \`  \  |  p       #
#    By: jeudy2552 <jeudy2552@floridapoly.edu>          |  \`-\   \ |  o       #
#                                                       |---\  \   `|  l       #
#    Created: 2018/05/31 21:54:47 by jeudy2552          | ` .\  \   |  y       #
#    Updated: 2018/05/31 21:54:47 by jeudy2552          -------------          #
#                                                                              #
# **************************************************************************** #

cd src/
rm -r classes/
mkdir classes/
javac -d classes/ files/Game.java files/AIProtocol.java && javac -cp classes/ -d classes/ files/SticksTest.java
echo "Rebuild complete"
echo "use 'java PickupSticks.SticksTest' to launch"
