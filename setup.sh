#!/usr/bin/env bash
# **************************************************************************** #
#                                                                              #
#                                                             |\               #
#    setup.sh                                           ------| \----          #
#                                                       |    \`  \  |  p       #
#    By: jeudy2552 <jeudy2552@floridapoly.edu>          |  \`-\   \ |  o       #
#                                                       |---\  \   `|  l       #
#    Created: 2018/05/31 21:38:14 by jeudy2552          | ` .\  \   |  y       #
#    Updated: 2018/05/31 21:38:14 by jeudy2552          -------------          #
#                                                                              #
# **************************************************************************** #

cd src/
mkdir classes
javac -d classes/ files/Game.java files/AIProtocol.java && javac -cp classes/ -d classes/ files/SticksTest.java
echo "Setup complete!"
echo "Use 'java PickupSticks.SticksTest' to launch"
