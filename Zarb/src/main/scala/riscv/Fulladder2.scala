package riscv
import chisel3._
class Fulladder2 extends Module{
val io=IO(new Bundle{
 val a0=Input(UInt(1.W))
 val a1=Input(UInt(1.W))
 val b0=Input(UInt(1.W))
 val b1=Input(UInt(1.W))
 val cin0=Input(UInt(1.W))
 val sum0=Output(UInt(1.W))
 val sum1=Output(UInt(1.W))
 val cout1=Output(UInt(1.W))
})
 val fulladd1=Module(new Fulladder())
 val fulladd2=Module(new Fulladder())
 fulladd1.io.a:=io.a0
 fulladd1.io.b:=io.b0
 fulladd1.io.cin:=io.cin0
 io.sum0:=fulladd1.io.sum
 fulladd2.io.cin:=fulladd1.io.cout
 fulladd2.io.a:=io.a1
 fulladd2.io.b:=io.b1
 io.sum1:=fulladd2.io.sum
 io.cout1:=fulladd2.io.cout
}
