### Matrix - a squared matrix clockwise walker app

This app walks a n x n matrix starting at `0,0` and turning clockwise, avoiding repetitions.

#### Requirements

- Java 11 or superior
- Apache Maven
- (optional) since it was developed in intelliJ, metadata files have been included.

#### How to run it

It's currently configured to match the example given in the challenge.

- Easiest way is using intelliJ: import project, allow maven plugin to load dependencies (alternatively try maven build goal manually just to be sure).
- You can also add a target to run it from `pom.xml` directly.

#### What can be done better?

- The assumption of a squared matrix simplifies things. It could easily support m x n matrices as well.
- Unit test coverage isn't optimal - methods in Main can use some love
- `Step.turn()` feels a bit out of place, it can be reimplemented so that it does adds noise to exit check.
- If it were to optimize for space complexity, pretty much all of the `Coordinate`, `Step` code can go (or relocate to `Main`). 
  - By manipulating matrix indices we can also deduct when to turn, and when to exit. Code may end up a bit less pretty, but it'll surely improve in space handling. 
