package riscv
import chisel3._
class Fulladder4 extends Module{
val io=IO(new Bundle{
 val c0=Input(UInt(1.W))
 val d0=Input(UInt(1.W))
 val c1=Input(UInt(1.W))
 val d1=Input(UInt(1.W))
 val cin2=Input(UInt(1.W))
 val sum2=Output(UInt(1.W))
 val sum3=Output(UInt(1.W))
 val cout2=Output(UInt(1.W))
})
 val add1=Module(new Fulladder2())
 val add2=Module(new Fulladder2())
 add1.io.a0:=io.c0
 add1.io.b0:=io.d0
 add1.io.cin0:=io.cin2
 io.sum2:=add1.io.sum0
 add2.io.cin0:=add1.io.cout1
 add2.io.a1:=io.c1
 add2.io.b1:=io.d1
 io.sum3:=add2.io.sum0
 io.cout2:=add2.io.cout1
}
