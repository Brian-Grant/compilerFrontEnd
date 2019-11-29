from checker import checker
from env import Env

class CodeSymtab:

    def __init__(self):
        self.envs = [checker.types]

    def begin_scope(self):
        self.envs.append(Env())

    def end_scope(self):
        self.envs.pop()

    def get(self, name):
        for env in self.envs[::-1]:
            info = env.get(name)
            if info: return info
        return None

    def put(self, name, info):
        self.envs[-1][name] = info
