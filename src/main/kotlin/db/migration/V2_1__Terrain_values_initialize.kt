package db.migration

import io.stud.forest.springsamples.fantasy_world.repositories.TerrainsRepository
import org.flywaydb.core.api.migration.BaseJavaMigration
import org.flywaydb.core.api.migration.Context
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.SingleConnectionDataSource

/**
 * Flyway doesn't detect Java migrations
 *  try fix it later now im going to use sql migration
 */
class V2_1__Terrain_values_initialize
@Autowired
constructor(
        private val terrainsRepository: TerrainsRepository
) : BaseJavaMigration() {

    override fun migrate(context: Context?) {

        val template = JdbcTemplate(SingleConnectionDataSource(context!!.connection, true))
        val query = """
            INSERT INTO terrains (name)
            VALUES
                ("mountains"),
                ("sea"),
                ("highlands"),
                ("ocean"),
                ("plains"),
                ("forest"),
                ("swamp"),
                ("desert"),
                ("coast"),
                ("fields"),
                ("permafrost"),
                ("vulcan"),
                ("underground");
        """.trimIndent()

        template.execute(query)

    }
}