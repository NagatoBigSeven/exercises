package debugging

class UsersTest extends munit.FunSuite:
  test("createNewUser: create 3 new users"):
    deleteAllUsers()
    assertEquals(createNewUser(1), true)
    assertEquals(createNewUser(2), true)
    assertEquals(createNewUser(1), false)
    assertEquals(createNewUser(3), true)
    assertEquals(getUsers(), IntCons(3, IntCons(2, IntCons(1, IntNil()))))

  test("createNewVipUser: create 3 new VIP users"):
    deleteAllUsers()
    assertEquals(createNewVipUser(1), true)
    assertEquals(createNewVipUser(2), true)
    assertEquals(createNewVipUser(1), false)
    assertEquals(createNewVipUser(3), true)
    assertEquals(getVipUsers(), IntCons(3, IntCons(2, IntCons(1, IntNil()))))

  test("upgradeUserToVip: if the user exists"):
    deleteAllUsers()
    assertEquals(createNewUser(1), true)
    assertEquals(upgradeUserToVip(1), true)
    assertEquals(getVipUsers(), IntCons(1, IntNil()))

  test("upgradeUserToVip: if the user doesn't exist"):
    deleteAllUsers()
    assertEquals(upgradeUserToVip(1), false)
    assertEquals(getVipUsers(), IntNil())
