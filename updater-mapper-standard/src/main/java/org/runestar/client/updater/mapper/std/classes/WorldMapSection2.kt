package org.runestar.client.updater.mapper.std.classes

import org.objectweb.asm.Type.*
import org.runestar.client.updater.mapper.IdentityMapper
import org.runestar.client.updater.mapper.DependsOn
import org.runestar.client.updater.mapper.and
import org.runestar.client.updater.mapper.predicateOf
import org.runestar.client.updater.mapper.type
import org.runestar.client.updater.mapper.Class2

@DependsOn(WorldMapSection::class)
class WorldMapSection2 : IdentityMapper.Class() {
    override val predicate = predicateOf<Class2> { it.superType == Any::class.type }
            .and { it.interfaces.contains(type<WorldMapSection>()) }
            .and { it.instanceFields.count { it.type == INT_TYPE } == 6 }
}