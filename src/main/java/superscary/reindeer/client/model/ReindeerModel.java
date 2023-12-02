package superscary.reindeer.client.model;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import superscary.reindeer.ReindeerMod;
import superscary.reindeer.client.animation.ReindeerAnimation;
import superscary.reindeer.entity.ReindeerEntity;

public class ReindeerModel<T extends ReindeerEntity> extends HierarchicalModel<ReindeerEntity>
{
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ReindeerMod.MODID, "reindeer_entity"), "main");
	private final ModelParts parts;

	public ReindeerModel(ModelPart root)
	{
		ModelPart body = root.getChild("body");
		ModelPart head = body.getChild("head");
		ModelPart neck = body.getChild("neck");
		ModelPart frontLeft = body.getChild("frontLeft");
		ModelPart frontRight = body.getChild("frontRight");
		ModelPart backLeft = body.getChild("backLeft");
		ModelPart backRight = body.getChild("backRight");
		ModelPart tail = body.getChild("tail");

		this.parts = new ModelParts(body, head, neck, frontLeft, frontRight, backLeft, backRight, tail);
	}

	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -20.0F, -8.0F, 8.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition backLeft = body.addOrReplaceChild("backLeft", CubeListBuilder.create().texOffs(0, 29).addBox(-3.0F, 0.0F, -2.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -11.0F, 12.0F));

		PartDefinition backRight = body.addOrReplaceChild("backRight", CubeListBuilder.create().texOffs(8, 29).addBox(1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -11.0F, 11.0F));

		PartDefinition frontRight = body.addOrReplaceChild("frontRight", CubeListBuilder.create().texOffs(16, 29).addBox(1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -11.0F, -7.0F));

		PartDefinition frontLeft = body.addOrReplaceChild("frontLeft", CubeListBuilder.create().texOffs(24, 29).addBox(-3.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -11.0F, -7.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -16.0F, 8.0F));

		PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 34).addBox(-0.5F, -0.3447F, 0.3056F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 3.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -15.0F, -8.0F));

		PartDefinition cube_r2 = neck.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, -1.4334F, -4.9389F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -4.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(32, 29).addBox(-1.5F, -2.0F, -6.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -21.0F, -11.0F));

		PartDefinition antlerRight = head.addOrReplaceChild("antlerRight", CubeListBuilder.create().texOffs(0, 0).addBox(2.5F, -20.0F, -9.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 12).addBox(0.5F, -22.0F, -9.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(14, 10).addBox(0.5F, -19.0F, -9.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 14.0F, 7.0F));

		PartDefinition antlerLeft = head.addOrReplaceChild("antlerLeft", CubeListBuilder.create().texOffs(0, 10).addBox(2.5F, -20.0F, -9.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(15, 0).addBox(4.5F, -22.0F, -9.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(37, 34).addBox(3.5F, -19.0F, -9.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 7.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(ReindeerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
	{
		root().getAllParts().forEach(ModelPart::resetPose);

		animate(entity.idleAnimationState, ReindeerAnimation.IDLE, ageInTicks);

		if (!entity.isInWaterOrBubble())
		{
			animateWalk(ReindeerAnimation.WALK, limbSwing, limbSwingAmount,3.0f, 2.5f);
		}
		else {
			//todo swim anim
		}

		/*if (ageInTicks < 24000)
		{
			this.parts.body().xScale = 0.75f;
			this.parts.body().yScale = 0.75f;
			this.parts.body().zScale = 0.75f;
		}
		else
		{
			this.parts.body().xScale = 1;
			this.parts.body().yScale = 1;
			this.parts.body().zScale = 1;
		}*/

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
	{
		this.parts.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root ()
	{
		return this.parts.body();
	}

	private record ModelParts (ModelPart body, ModelPart head, ModelPart neck, ModelPart frontLeftLeg, ModelPart frontRightLeg, ModelPart backLeftLeg, ModelPart backRightLeg, ModelPart tail) {}
}