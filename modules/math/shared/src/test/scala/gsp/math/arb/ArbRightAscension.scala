// Copyright (c) 2016-2019 Association of Universities for Research in Astronomy, Inc. (AURA)
// For license information see LICENSE or https://opensource.org/licenses/BSD-3-Clause

package gsp.math.arb

import gsp.math.{ HourAngle, RightAscension }
import org.scalacheck._
import org.scalacheck.Arbitrary._

trait ArbRightAscension {
  import ArbAngle._

  implicit val arbRightAscension: Arbitrary[RightAscension] =
    Arbitrary(arbitrary[HourAngle].map(RightAscension.fromHourAngle.get))

  implicit val cogRightAscension: Cogen[RightAscension] =
    Cogen[HourAngle].contramap(RightAscension.fromHourAngle.reverseGet)

}

object ArbRightAscension extends ArbRightAscension
