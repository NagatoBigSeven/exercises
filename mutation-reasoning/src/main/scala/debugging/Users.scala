package debugging

var users: IntList = IntCons(101, IntCons(102, IntCons(103, IntNil())))
var vipUsers: IntList = IntCons(102, IntNil())

def deleteAllUsers() =
  users = IntNil()
  vipUsers = IntNil()

def getUsers(): IntList = users
def getVipUsers(): IntList = vipUsers

def createNewUser(id: Int): Boolean =
  if contains(users, id) then false
  else
    users = IntCons(id, users)
    true

def createNewVipUser(id: Int): Boolean =
  if contains(vipUsers, id) then false
  else
    vipUsers = IntCons(id, vipUsers)
    true

def upgradeUserToVip(id: Int): Boolean =
  val canCreateNewVipUser = createNewVipUser(id)
  contains(users, id) && canCreateNewVipUser
