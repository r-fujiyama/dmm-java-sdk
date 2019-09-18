from pathlib import Path
from Floor import Floor
import os

floor_java = Path.cwd().joinpath('../out')
if not os.path.exists(floor_java):
    os.mkdir(floor_java)

floor_java = floor_java.joinpath('Floor.java')
with open(floor_java, mode='w', encoding='UTF-8') as file:
    floor = Floor()
    floor.create(file)
