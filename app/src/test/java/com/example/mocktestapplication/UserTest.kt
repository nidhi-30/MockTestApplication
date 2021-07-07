package com.example.mocktestapplication

import junit.framework.TestCase

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UserTest : TestCase(){

    @Test
    fun validateInput(){
        assertEquals(User.validateField("snd"), false)
        assertEquals(User.validateField("123"), false)
        assertEquals(User.validateField("as83"), true)
        assertEquals(User.validateField("12kn"), true)
        assertEquals(User.validateField("938k1nfd32"), true)
        assertEquals(User.validateField(""), false)
        assertEquals(User.validateField("wekw24`;sn"), false)
    }

}